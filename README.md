# DataBindingBaseLib
一个基于DataBinding的基础Activity、Fragment、RecyclerAdapter

使用方法很简单：

1.Activity继承BaseDataBindingActivity

2.Fragment继承BaseDataBindingFragment

3.RecyelerAdapter继承BaseDataBindingRecyclerViewAdapter并在后方加入数据对象

例如:

public class MyAdapter extends BaseDataBindingRecyclerViewAdapter<MyData> {
}
