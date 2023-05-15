# Get the users names
user1 = input("Enter Player 1's name? ")
user2 = input("Enter Player 2's name? ")

# Get the users choices
user1_option = input(user1 + ", do you want to choose rock, paper or scissors? ").lower()
user2_option = input(user2 + ", do you want to choose rock, paper or scissors? ").lower()

# Run the algorithm to see who wins
if user1_option == user2_option:
    print("Its Tie")
elif user1_option == 'rock':
    if user2_option == 'scissors':
        print("Rock wins")
    else:
        print("Paper wins!")
elif user1_option == 'scissors':
    if user2_option == 'paper':
        print("Scissors win")
    else:
        print("Rock wins!")
elif user1_option == 'paper':
    if user2_option == 'rock':
        print("Paper wins")
    else:
        print("Scissors win")
else:
    print("Invalid option entered, try again")

    # Ask them if they want to play again
    repeat = input("Do you want to play another round? Yes/No: ").lower()

    # If they say yes, don't do anything
    if repeat == "yes":
        pass
    # If they say no, exit the game
    elif repeat == "no":
        raise SystemExit
    # If they say anything else, exit with an error message.
    else:
        print("You entered an invalid option. Exit now.")
        raise SystemExit
