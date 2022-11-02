import re

TEST_STRING = "Классное слово – обороноспособность, которое должно идти после слов: трава и молоко."

if __name__ == "__main__":
    test_string = re.findall(r"\w+", TEST_STRING)
    test_string = " ".join(test_string).lower()
    words = test_string.split()
    matching_words = []

    for word in words:
        vowels = set(re.findall(r"[аяуеыоэюи]+", word))

        if len(vowels) == 1:
            matching_words.append(word)

    print(*sorted(matching_words, key=lambda x: len(x)))
 