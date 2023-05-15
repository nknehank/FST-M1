# Subsets
"""In the same file as the previous activity, do the following:

Apply the marker 'activity' to the last 2 test methods.
Run tests based on substring
Run tests based using the 'activity' marker."""

import pytest
import math


# sum of two numbers
def test_sum():
    num1 = 5
    num2 = 10
    assert num1 + num2 == 15


# diff of two numbers
def test_sub():
    num1 = 5
    num2 = 10
    assert num2 - num1 == 10


# quotation of two numbers
@pytest.mark.activity
def test_quot():
    num1 = 50
    num2 = 10
    assert num1 / num2 == 5


# product of two numbers
@pytest.mark.activity
def test_mult():
    num1 = 50
    num2 = 10
    assert num1 * num2 == 500
