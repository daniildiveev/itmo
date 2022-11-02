import re

TEST_CORPUS = ("Классное слово – обороноспособность, которое должно идти после слов: трава и молоко.",
               "Олово золото красит",
               "Хорошо жить в мире, а не в войне", 
               "Волчок и юла крутятся", 
               "Быть или не быть: вот в чем вопрос")

if __name__ == "__main__":

    for test_string in TEST_CORPUS:
        test_string = re.findall(r"\w+", test_string)
        test_string = " ".join(test_string).lower()
        words = test_string.split()
        matching_words = []

        for word in words:
            vowels = set(re.findall(r"[аяуеыоэюи]+", word))

            if len(vowels) == 1:
                matching_words.append(word)

        print(*sorted(matching_words, key=lambda x: len(x)))
    