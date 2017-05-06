from .None import Node


class Queue:
    def __init__(self):
        self.top = None

    def add(self, value):
        newNode = Node(value)

        if (self.top == None):
            self.top = newNode
            return

        runner = self.top
        while (runner.next != None):
            runner = runner.next

        runner.next = newNode

    def remove(self, value):
        if (self.top == None):
            return

        while (self.top.value == value):
            self.top = self.top.next

        prev = runner = self.top
        runner = runner.next

        while (runner != None):
            if (runner.value == value):
                prev.next = runner.next
            else:
                prev = runner
            runner = runner.next

    def isEmpty(self):
        return self.top == None

    def toString(self, top, resStr):
        if (top == None):
            return

        resStr += top.value + " -> "
        self.toString(top.next, resStr)

    def __str__(self):
        res = ""
        self.toString(self.top, res)
        return res



