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
    return array
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
