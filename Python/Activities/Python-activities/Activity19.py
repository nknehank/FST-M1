# Writing Excel files
# Using pandas write following to csv
"""FirstName	LastName	Email	PhoneNumber
Satvik	Shah	satshah@example.com	4537829158
Avinash	Kati	avinashk@example.com	5892184058
Lahri	Rath	lahri.rath@example.com	4528727830"""

# Import pandas
import pandas
from pandas import ExcelWriter

# Create a dictionary that will be used to create the DataFrame
data = {
    'FirstName': ["Satvik", "Avinash", "Lahri"],
    'LastName': ["Shah", "Kati", "Rath"],
    'Email': ["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber': ["4537829158", "4892184058", "4528727830"]
}

# Create the DataFrame that will be written to the excel file
dataframe = pandas.DataFrame(data)

# Print the dataframe
print(dataframe)

# Write the dataframe to a Excel file
writer = ExcelWriter('../resources/sample2.xlsx')
dataframe.to_excel(writer, 'Sheet1', index=False)

# Commit data to the Excel file
writer.save()