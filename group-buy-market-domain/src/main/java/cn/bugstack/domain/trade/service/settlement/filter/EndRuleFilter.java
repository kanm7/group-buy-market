package cn.bugstack.domain.trade.service.settlement.filter;

import cn.bugstack.domain.trade.model.entity.GroupBuyTeamEntity;
import cn.bugstack.domain.trade.model.entity.TradeSettlementRuleCommandEntity;
import cn.bugstack.domain.trade.model.entity.TradeSettlementRuleFilterBackEntity;
import cn.bugstack.domain.trade.service.settlement.factory.TradeSettlementRuleFilterFactory;
import cn.bugstack.types.design.framework.link.model2.handler.ILogicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 结束节点
 * @create 2025-01-29 16:37
 */
@Slf4j
@Service
public class EndRuleFilter implements ILogicHandler<TradeSettlementRuleCommandEntity, TradeSettlementRuleFilterFactory.DynamicContext, TradeSettlementRuleFilterBackEntity> {

    @Override
    public TradeSettlementRuleFilterBackEntity apply(
            TradeSettlementRuleCommandEntity requestParameter,
            TradeSettlementRuleFilterFactory.DynamicContext dynamicContext) throws Exception {

        log.info("结算规则过滤 - 结束节点{} outTradeNo:{}",
                requestParameter.getUserId(), requestParameter.getOutTradeNo());

        // 从上下文中获取拼团对象
        GroupBuyTeamEntity groupBuyTeamEntity = dynamicContext.getGroupBuyTeamEntity();

        // 封装并返回完整信息
        return TradeSettlementRuleFilterBackEntity.builder()
                .teamId(groupBuyTeamEntity.getTeamId())              // 团队 ID
                .activityId(groupBuyTeamEntity.getActivityId())      // 活动 ID
                .targetCount(groupBuyTeamEntity.getTargetCount())    // 目标人数
                .completeCount(groupBuyTeamEntity.getCompleteCount()) // 已完成人数
                .lockCount(groupBuyTeamEntity.getLockCount())        // 锁单人数
                .status(groupBuyTeamEntity.getStatus())              // 拼团状态
                .validStartTime(groupBuyTeamEntity.getValidStartTime()) // 开始时间
                .validEndTime(groupBuyTeamEntity.getValidEndTime())     // 结束时间
                .build();
    }

}
