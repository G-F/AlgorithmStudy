# 挿入ソート(Ruby版)
class InsertSort
  def createRandomArray(num)
    result = []
    for i in 1..num do
      result.push(rand(100))
    end
    return result
  end

  def insertSort(array)
    #挿入ソートの処理を書く
    i = 0
    while i < array.length do
      insert(array, i, array[i])
      i += 1
    end
    return array
  end

  def insert(array, pos, value)
    #挿入ソートの各回の処理
    index = pos -1;
   while index >= 0 && array[index] > value do
      array[index + 1] = array[index];
      index -= 1
    end
    array[index + 1] = value
  end
end

if __FILE__ == $0
  sort = InsertSort.new()
  array = sort.createRandomArray(10)
  p "整列前："
  p array
  sortedArray = sort.insertSort(array)
  p "整列後："
  p sortedArray
end
