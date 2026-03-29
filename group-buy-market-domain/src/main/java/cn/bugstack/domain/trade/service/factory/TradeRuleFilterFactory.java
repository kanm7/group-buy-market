package cn.bugstack.domain.trade.service.factory;

import cn.bugstack.domain.trade.model.entity.GroupBuyActivityEntity;
import cn.bugstack.domain.trade.model.entity.TradeRuleCommandEntity;
import cn.bugstack.domain.trade.model.entity.TradeRuleFilterBackEntity;
import cn.bugstack.domain.trade.service.filter.ActivityUsabilityRuleFilter;
import cn.bugstack.domain.trade.service.filter.UserTakeLimitRuleFilter;
import cn.bugstack.types.design.framework.link.model2.LinkArmory;
import cn.bugstack.types.design.framework.link.model2.chain.BusinessLinkedList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 交易规则过滤工厂
 * @create 2025-01-25 08:41
 */
@Slf4j
@Service
public class TradeRuleFilterFactory {

    /**
     * - ✅ **自动化装配**：不需要手动调用 `appendNext()`，通过 `LinkArmory` 一键完成
     * - ✅ **Spring 集成**：通过 `@Bean` 注入到 Spring 容器，随时可用
     * - ✅ **可扩展性强**：后续添加新的规则过滤器只需在构造函数中添加参数即可    
     * @param activityUsabilityRuleFilter
     * @param userTakeLimitRuleFilter
     * @return
     */

    @Bean("tradeRuleFilter")
    public BusinessLinkedList<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> tradeRuleFilter(ActivityUsabilityRuleFilter activityUsabilityRuleFilter, UserTakeLimitRuleFilter userTakeLimitRuleFilter) {
        // 组装链
        LinkArmory<TradeRuleCommandEntity, TradeRuleFilterFactory.DynamicContext, TradeRuleFilterBackEntity> linkArmory =
                new LinkArmory<>("交易规则过滤链", activityUsabilityRuleFilter, userTakeLimitRuleFilter);

        // 链对象
        return linkArmory.getLogicLink();
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        // 拼团活动实体 - 由第一个节点查询并设置，传递给后续节点使用

        private GroupBuyActivityEntity groupBuyActivity;

    }

}
