import re

REGEXP = r"\s.*[аяуеыоэюи]{2}.*\s"
TEST_CORPUS = ("Кривошеее существо гуляет по парку",)

if __name__ == "__main__":
    for test_string in TEST_CORPUS:
        print(test_string)
        print(re.findall(REGEXP, test_string))