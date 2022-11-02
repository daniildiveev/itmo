EYES_DICT = {0: ':', 1: ';', 2: 'X', 3: '8', 4: '='}
NOSE_DICT = {0: '-', 1: '<', 2: '-{', 3: '<{'}
MOUTH_DICT = {0: '(', 1: ')', 2: 'O', 3: '|', 4: '\\', 5: '/', 6: 'P'}

if __name__ == "__main__":
    isu = int(input("Your ISU >>"))

    eyes = EYES_DICT.get(isu % 5)
    nose = NOSE_DICT.get(isu % 4)
    mouth = MOUTH_DICT.get(isu % 7) 

    print("Your emoji: %s " % (eyes + nose + mouth))

