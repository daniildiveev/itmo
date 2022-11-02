SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.xml"

def extract_data(source_string:str, 
                 target:str,
                 last_n_parts_to_take:int=1) -> str:
    data_index = source_string.find(target)
    data = source_string[data_index:source_string.find(",")]
    data = [string for string in data.split() if string != ""][-last_n_parts_to_take:]

    return " ".join(data)


def parse_json(source_file:str) -> dict:
    timetable_dict = {}

    with open(SOURCE_FILE) as f:
        data = f.read()

    data = "".join(data.splitlines())    
    data = "".join(data.split("{"))
    data = "".join(data.split("}"))
    data = data.replace('"', '')
    data = data.split("subject")[1:]

    for i in range(len(data)):
        timetable_dict[f"subject{i+1}"] = {}

        for part in ("day", "time", "name", "teacher", "week", "location"):
            if part in ("teacher", "format"):
                value = extract_data(data[i], part, 3)
            elif part == "location":
                value = extract_data(data[i], part, 4)
            else:
                value = extract_data(data[i], part)

            timetable_dict[f"subject{i+1}"][part] = value
            data[i] = data[i][data[i].find(",") + 1:] 

    return timetable_dict


if __name__ == "__main__":
    data = parse_json(SOURCE_FILE)