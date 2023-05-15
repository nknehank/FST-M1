# Using Pnadas write following data in csv

"""Usernames	Passwords
admin	password
Charles	Charl13
Deku	AllMight"""

# Import pandas
import pandas as pd

#  Dictionary for data
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a DataFrame using that data
dataframe = pd.DataFrame(data)

# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("sample.csv", index=False)
