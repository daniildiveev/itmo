import json
from dict2xml import dict2xml

SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.xml"

if __name__ == "__main__":
    with open(SOURCE_FILE) as f:
        data = json.load(f)
    
    xml_code = dict2xml(data)

    with open(OUTPUT_FILE, 'w') as f:
        f.write(xml_code)