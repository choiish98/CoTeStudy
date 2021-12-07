import sys
import re

STRING = sys.stdin.readline().strip()  # INPUT: 문자열

def print_error():
    print("Error!")
    sys.exit()

def snake_to_camel(string):
    s_list = list(string)
    underbar_count = 0
    for index, char in enumerate(s_list):
        if char == "_":
            underbar_count += 1
            if underbar_count == 2:
                print_error()
            try:
                s_list[index+1] = s_list[index+1].upper()
            except IndexError:
                pass
        else:
            underbar_count = 0

    result = "".join(s_list).replace("_", "")
    
    return result

def camel_to_snake(string):
    s_list = list(string)
    for index, char in enumerate(s_list):
        if char.isupper():
            s_list[index] = "_" + char.lower()
    
    result = "".join(s_list)

    return result

is_start_lower = re.match('^[a-z]', STRING)
if not is_start_lower:
    print_error()

if not(STRING.isalpha() or "_" in STRING):
    print_error()

if STRING[-1] == "_":
    print_error()

if STRING.lower() != STRING:
    if "_" in STRING:
        print_error()
    else:
        print(camel_to_snake(STRING))
else:
    print(snake_to_camel(STRING))
    
