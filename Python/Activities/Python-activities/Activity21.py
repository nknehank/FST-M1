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


def test_quot():
    num1 = 50
    num2 = 10
    assert num1 / num2 == 5


def test_mult():
    num1 = 50
    num2 = 10
    assert num1 * num2 == 500
