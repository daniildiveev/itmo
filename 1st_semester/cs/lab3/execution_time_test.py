import time
from manual_parser import parse_json, create_xml_code, dump_to_xml
from parsing_with_libs import parse_json_and_dump_to_xml
from manual_parser_with_regex import parse_json_with_regex

SOURCE_FILE = "timetable.json"
OUTPUT_FILE = "timetable.xml"
N_TESTS = 1000

if __name__ == "__main__":
    print(f"Time took to execute {N_TESTS} tests: ")

    start = time.time()

    for _ in range(1000):
        data = parse_json(SOURCE_FILE)
        xml_code = create_xml_code(data)
        dump_to_xml(OUTPUT_FILE, xml_code)

    print(f"Manual parsing without regex: {time.time() - start}")

    start = time.time()

    for _ in range(1000):
        data = parse_json_with_regex(SOURCE_FILE)
        xml_code = create_xml_code(data)
        dump_to_xml(OUTPUT_FILE, xml_code)

    print(f"Manual parsing with regex: {time.time() - start}")

    start = time.time()

    for _ in range(1000):
        parse_json_and_dump_to_xml(SOURCE_FILE, OUTPUT_FILE)

    print(f"Manual parsing using libraries: {time.time() - start}")


    