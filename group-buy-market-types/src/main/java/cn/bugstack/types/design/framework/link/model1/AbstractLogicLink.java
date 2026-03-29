package cn.bugstack.types.design.framework.link.model1;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽象类  提供默认实现，减少重复代码。
 * @create 2025-01-18 09:14
 * 
 * 
 * ✅ 实现 next 字段的存储和管理
 * ✅ 实现 next() 和 appendNext() 方法
 * ✅ 提供 next(...) 委托方法（调用下一个节点）
 * ✅ 为什么要有抽象类？ → 避免每个实现类都写一遍相同的代码
 */
public abstract class AbstractLogicLink<T, D, R> implements ILogicLink<T, D, R> {

    private ILogicLink<T, D, R> next;

    @Override
    public ILogicLink<T, D, R> next() {
        return next;
    }

    @Override
    public ILogicLink<T, D, R> appendNext(ILogicLink<T, D, R> next) {
        this.next = next;
        return next;
    }

    protected R next(T requestParameter, D dynamicContext) throws Exception {
        return next.apply(requestParameter, dynamicContext);
    }

}
