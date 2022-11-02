import re 

EMOJI = ":<|"
EMOJI_REGEXP = r":<\|"
TEST_CORPUS = ("^%&$*&^%&^$%:<|>:<|",
               ":<<<|>|:<|",
               "|||<<>:", 
               "(*&$#(>>><<:<|:<|:|",
               "(*)(\\\\\\\\|<:<|")

if __name__ == "__main__":
    for test_string in TEST_CORPUS:
        print("Number of emojis found by regex: %s" % len(re.findall(EMOJI_REGEXP,test_string)))
        print("Number of emojis found by python: %s" % test_string.count(":<|"))