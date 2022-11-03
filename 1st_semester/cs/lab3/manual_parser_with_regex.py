import re
from manual_parser import create_xml_code, dump_to_xml

SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.xml"

def parse_json(source_file:str) -> dict:
    with open(source_file) as f:
        string_to_parse = f.read()

    dicts = re.findall(r'.*\"(.+)\"\s*:\s*\n?\s*\{.*', string_to_parse)
    fields = re.findall(r'"(.+)" : "(.+)"', string_to_parse)

    output_dict = {}
    output_dict[dicts[0]] = {}

    n_fields = len(fields) // (len(dicts) - 1)

    for i in range(1, len(dicts)):
        output_dict[dicts[0]][dicts[i]] = {}

        for k, v in fields[(i-1)*n_fields:i*n_fields]:
            output_dict[dicts[0]][dicts[i]][k] = v

    return output_dict
    
if __name__ == "__main__":
    data = parse_json(SOURCE_FILE)
    xml_code = create_xml_code(data)
    dump_to_xml(OUTPUT_FILE, xml_code)