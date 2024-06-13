class Heap():
    def i_child_left(self, i):
        return (i * 2 + 1)

    def i_child_right(self, i):
        return i * 2 + 2

    def swap(self, arr, i, j):
        t = arr[i]
        arr[i] = arr[j]
        arr[j] = t

    def sift_down(self, arr, start, end):
        largest = start
        if(self.i_child_left(start) <= end and arr[self.i_child_left(start)] > arr[start]):
            largest = self.i_child_left(start)
        if(self.i_child_right(start) <= end and arr[self.i_child_right(start)] > arr[largest]):
            largest = self.i_child_right(start)

        if(start != largest):
            self.swap(arr, start, largest)
            self.sift_down(arr, largest, end)

    def heapify(self, arr, start, end):
        if(start >= 0):
            self.sift_down(arr, start, end)
            start = start - 1
            self.heapify(arr, start, end)

    def heap_sort(self, arr, start, end):
        if(start < end):
            self.swap(arr, start, end)
            end = end - 1
            self.sift_down(arr, start, end)
            self.heap_sort(arr, start, end)












def main():
    a = [0, 5, 1, 7, 9, 8, 2, 100, 2341, -213, 3]
    h = Heap()
    start = int(len(a) / 2 - 1)
    end = len(a) - 1
    h.heapify(a, start, end)
    h.heap_sort(a, 0, len(a) - 1)
    print(a)



if __name__ == '__main__':
    main()