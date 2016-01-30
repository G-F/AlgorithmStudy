# クイックソート(Ruby版)
class QiuckSort
  def createRandomArray(num)
    result = []
    for i in 1..num do
      result.push(rand(100))
    end
    return result
  end

  def quickSort(array, left, right)
    if (left >= right)
      return
    end
    axis = partition(array,left,right)

    quickSort(array,left,axis-1)
    quickSort(array,axis+1,right)
  end

  def partition(array,left,right)
    ## 軸値は左端と右端の中間値にする
    axis = left + ((right - left) / 2 )

    array.swap!(right,axis)
    store = left

    for i in left .. right-1 do
      if(array[i] <= array[right])
        array.swap!(i,store)
        store += 1
      end
    end
    array.swap!(store, right)
    return store
  end
end

class Array
  def swap!(a,b)
    self[a],self[b] = self[b],self[a]
  end
end

  if __FILE__ == $0
    sort = QiuckSort.new()
    array = sort.createRandomArray(10)
    p "整列前："
    p array
    sort.quickSort(array,0,9)
    p "整列後："
    p array
  end
