/**
 * @author dy
 * Service 逻辑注解。
 * 主要用户补充Service逻辑，如在添加文章之后需要先生成动态，@CreateDynamic
 * 标识: _Tran 表示改注解影响了事务，需要在Manager调用者处添加事务。（约定）
 * 
 */
package com.xipin.est.service.apsect.annotation;