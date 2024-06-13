def i_father(i):
    return int((i-1)/2)

def i_child_left(i):
    return i * 2 + 1

def i_child_right(i):
    return i * 2 + 2

def swap(arr, i, j):
    t = arr[i]
    arr[i] = arr[j]
    arr[j] = t

def sift_down(arr, start, end):
    largest = start
    if(i_child_left(start) <= end and arr[i_child_left(start)] > arr[start]):
        largest = i_child_left(start)
    if(i_child_right(start) <= end and arr[i_child_right(start)] > arr[largest]):
        largest = i_child_right(start)
    if(largest != start):
        swap(arr, start, largest)
        sift_down(arr, largest, end)

def sift_up(arr, start):
    smallest = start
    if(i_father(start) >= 0 and arr[start] > arr[i_father(start)]):
        smallest = i_father(start)
    if(smallest != start):
        swap(arr, start, smallest)
        sift_up(arr, smallest)

def build_max_heap(arr, start, end):
    if(start <= end):
        sift_up(arr, start)
        start = start + 1
        build_max_heap(arr, start, end)

def heap_sort(arr, end):
    if(0 < end):
        swap(arr, 0, end)
        end = end - 1
        sift_down(arr, 0, end)
        heap_sort(arr, end)

def main():
    a = [0, 5, 1, 7, 9, 8, 2, 100, 2341, -213, 3]
    build_max_heap(a, 1, len(a) - 1)
    heap_sort(a, len(a) - 1)
    print(a)



if __name__ == '__main__':
    main()
