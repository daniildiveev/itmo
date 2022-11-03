import json
from dict2xml import dict2xml

SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.xml"

def parse_json_and_dump_to_xml(source_file:str,
                               output_file:str) -> None:
    with open(source_file) as f:
        data = json.load(f)
    
    xml_code = dict2xml(data)

    with open(output_file, 'w') as f:
        f.write(xml_code)

if __name__ == "__main__":
    parse_json_and_dump_to_xml(SOURCE_FILE, OUTPUT_FILE)