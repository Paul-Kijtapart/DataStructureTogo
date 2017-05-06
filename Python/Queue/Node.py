class Node:
    def __init__(self, value):
        self.value = value
        self.next = None

    def __repr__(self):
        return "Value: %s" % (self.value)

    def __str__(self):
        return (
            "{ \n" +
            "Value: " + self.value + " \n} "
        )
