import re
from itertools import product
 
VOWELS = 'аяуеыоэюи'
CONSONANTS = 'бвгджзйклмнпрстфхцчшщ'
REGEXP = r"([А-Яа-я]*[аяуеыоэюи]{2}[А-Яа-я]*)\s\S[аяуеыоэюи]*[бвгджзйклмнпрстфхцчшщ]{0,1}[аяуеыоэюи]*[бвгджзйклмнпрстфхцчшщ]{0,1}[аяуеыоэюи]*[бвгджзйклмнпрстфхцчшщ]{0,1}[аяуеыоэюи]*\b"
TEST_CORPUS = ("Кривошеее существо гуляет по парку", 
               "Девочка идет ловить рыбу", 
               "Мальчик идет кататься на санках", 
               "Мальчик будет строить башню", 
               "Бабушка пошла набрать воды")

if __name__ == "__main__":
    for test_string in TEST_CORPUS:
        test_string = test_string.lower()
        words = test_string.split()
        matching_words = []

        for i in range(len(words) - 1):
            for pair in tuple(product(VOWELS, repeat=2)):
                pair = ''.join(pair)

                if pair in words[i]:
                    consonants_count = sum([words[i+1].count(l) for l in CONSONANTS])

                    if consonants_count <= 3:
                        matching_words.append(words[i])

        print(f"Words found by python: {matching_words}")      
        print(f"Words found by regex: {re.findall(REGEXP, test_string, flags=re.IGNORECASE)}")