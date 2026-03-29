package cn.bugstack.types.design.framework.link.model1;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 
 * @create 2025-01-18 09:09
 * 
 * 继承 ILogicChainArmory（获得组装能力）
 * ✅ 定义 apply() 方法（执行业务逻辑）
 * ✅ 是链表节点的总接口
 */
public interface ILogicLink<T, D, R> extends ILogicChainArmory<T, D, R> {


    // 核心方法：处理请求
    R apply(T requestParameter, D dynamicContext) throws Exception;

}
