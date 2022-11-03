SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.csv"

def extract_data(source_string:str, 
                 target:str,
                 last_n_parts_to_take:int=1) -> str:
    data_index = source_string.find(target)
    data = source_string[data_index:source_string.find(",")]
    data = [string for string in data.split() if string != ""][-last_n_parts_to_take:]

    return " ".join(data)


def parse_json(source_file:str) -> dict:
    timetable_dict = {
        'timetable' : {}
    }

    with open(source_file) as f:
        data = f.read()

    data = "".join(data.splitlines())    
    data = "".join(data.split("{"))
    data = "".join(data.split("}"))
    data = data.replace('"', '')
    data = data.split("subject")[1:]

    for i in range(len(data)):
        timetable_dict['timetable'][f"subject{i+1}"] = {}

        for part in ("day", "time", "name", "teacher", "week", "location"):
            if part in ("teacher", "format"):
                value = extract_data(data[i], part, 3)
            elif part == "location":
                value = extract_data(data[i], part, 4)
            else:
                value = extract_data(data[i], part)

            timetable_dict['timetable'][f"subject{i+1}"][part] = value
            data[i] = data[i][data[i].find(",") + 1:] 

    return timetable_dict

def create_csv_rows(data:dict, 
               delimiter:str=",") -> str:
    csv_rows = []
    data_keys = list(data.keys())

    if len(data_keys) == 1:
        return create_csv_rows(data[data_keys[0]], delimiter)

    csv_row = ''

    for i, key in enumerate(data_keys):
        if isinstance(data[key], dict):
            csv_rows += create_csv_rows(data[key])
        else:
            if i == len(data_keys) - 1:
                csv_row += data[key] 
            else:
                csv_row += data[key] + delimiter

    if csv_row:
        csv_rows.append(csv_row)

    return csv_rows

def create_csv(data:dict,
               output_file:str,
               delimiter:str=",") -> None:
    csv_rows = create_csv_rows(data, delimiter)
    csv_rows = [f"{i}{delimiter}{csv_row}" for i, csv_row in enumerate(csv_rows)]

    header = "," * (len(csv_rows[0].split(",")) - 1) + "\n"
    csv = header + "\n".join(csv_rows)

    with open(output_file, 'w') as f:
        f.write(csv)

if __name__ == "__main__":
    data = parse_json(SOURCE_FILE)
    create_csv(data, OUTPUT_FILE)
