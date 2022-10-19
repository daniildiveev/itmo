def check_for_errors(message:str) -> None:
    if len(message) != 7:
        raise ValueError("sequence must be exactly 7 characters long")

    NOTATIONS = ("r1", "r2", "i1", "r3", "i2", "i3", "i4")
    bits = [int(c) for c in message]

    syndrome = (
        bits[0] ^ bits[2] ^ bits[4] ^ bits[6],
        bits[1] ^ bits[2] ^ bits[5] ^ bits[6],
        bits[3] ^ bits[4] ^ bits[5] ^ bits[6]
    )

    print(f"Syndrome: {syndrome}")

    if syndrome == (0, 0, 0):
        print("There are no errors")
    else:
        syndrome_string = "".join([str(bit) for bit in syndrome])[::-1]
        wrong_bit = int(syndrome_string, 2)
        bits[wrong_bit - 1] = (bits[wrong_bit - 1] + 1) % 2
        fixed_message = "".join([str(bit) for bit in bits])

        print(f"Error at {NOTATIONS[wrong_bit - 1]}, wrong bit: {wrong_bit} \nFixed sequence: {fixed_message}")

if __name__ == "__main__":
    message = input("Your message >> ")
    check_for_errors(message)