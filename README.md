# DataBindingBaseLib
一个基于DataBinding的基础Activity、Fragment、RecyclerAdapter

使用方法很简单：

Activity继承BaseDataBindingActivity

public class MainActivity extends BaseDataBindingActivity {

    private ActivityMainBinding binding;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;//此处填入activity的layout.xml
    }

    @Override
    protected void init(ViewDataBinding baseBinding) {
        binding= (ActivityMainBinding) baseBinding;//强转为当前Activity的ViewDataBinding对象
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void viewOnClick(View v) {

    }
}

Fragment继承BaseDataBindingFragment

public class MyFragment extends BaseDataBindingFragment {
    private FragmentMyBinding binding;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;//此处填入fragment的layout.xml
    }

    @Override
    protected void init(ViewDataBinding baseBinding) {
        binding= (FragmentMyBinding) baseBinding;//强转为当前fragment的ViewDataBinding对象
    }

    @Override
    protected void initListener() {

    }
}
RecyelerAdapter继承并在后方加入数据对象
public class MyAdapter extends BaseDataBindingRecyclerViewAdapter<BaseInfo> {
    public MyAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public int getLayout() {
        return 0;//此处填入adapter的layout.xml
    }

    @Override
    public void onBindView(ViewDataBinding dataBinding, BaseInfo bean, int position) {
				//第一个参数需要强转当前Adapter对应的ViewDataBinding 与Activity和Fragment的使用方法相同
				//第二个参数的数据类型会 泛型处传入的数据类型相同，拿到的数据即为当前postion的数据
				//第三个参数为当前position
    }
}
