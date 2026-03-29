package cn.bugstack.types.design.framework.link.model2.handler;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 逻辑处理器
 * @create 2025-01-18 09:43
 */
public interface ILogicHandler<T, D, R> {


    /**
     * // default 方法：有默认实现，实现类可以选择性重写
     * 这个方法的实际作用是这样的，在整个逻辑链中，如果某个节点
     * 需要提前返回，那么它会返回一个非空的结果；如果返回null，则继续执行下一个节点
     * @param requestParameter
     * @param dynamicContext
     * @return
     */
    default R next(T requestParameter, D dynamicContext) {
        return null;
    }

    R apply(T requestParameter, D dynamicContext) throws Exception;

}
