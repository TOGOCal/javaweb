alert("演示变长数组")
var arr1=[1,2,3]
arr1[10]=10
alert(arr1)

arr1[2]="hello"
alert(arr1)

var arr2=[1,2,3]
alert("原数组："+arr2)

arr2.push(4)
alert("添加后："+arr2)

arr2.splice(1,2)//从哪个下标的元素开始删，删多少个
alert("删除后："+arr2)

