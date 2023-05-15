class Car:
    '''This class represents a car'''

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " is moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " has stopped")


car1obj = Car("Toyota", "Basic", "2014", "Manual", "Silver")
car2obj = Car("BMW", "Top", "2013", "Manual", "Red")
car3obj = Car("Suzuki", "Swift", "2011", "Automatic", "White")

car1obj.accelerate()
car1obj.stop()
