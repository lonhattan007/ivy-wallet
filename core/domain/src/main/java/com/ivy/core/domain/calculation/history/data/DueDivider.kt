package com.ivy.core.domain.calculation.history.data

import com.ivy.core.data.common.Value

data class DueDivider(
    val income: Value?,
    val expense: Value?,
    val type: DueDividerType,
    override val sectionId: String
) : Collapsable, TransactionListItem