算法练习
1.快速排序是对冒泡排序的一种改进。
它的基本思想是，通过一趟排序，将要排序的数据分割成独立的两部分。其中一部分的数据要比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行排序。整个排序过程可以递归进行，以此达到整个数据变成有序序列。
最坏的实践复杂度为O(n2)，最好情况的时间复杂度为O(nlog2n)
