package com.ivy.core.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ivy.core.persistence.dao.AttachmentDao
import com.ivy.core.persistence.dao.account.AccountDao
import com.ivy.core.persistence.dao.account.AccountFolderDao
import com.ivy.core.persistence.dao.trn.TrnDao
import com.ivy.core.persistence.dao.trn.TrnLinkRecordDao
import com.ivy.core.persistence.dao.trn.TrnMetadataDao
import com.ivy.core.persistence.entity.account.AccountEntity
import com.ivy.core.persistence.entity.account.AccountFolderEntity
import com.ivy.core.persistence.entity.attachment.AttachmentEntity
import com.ivy.core.persistence.entity.attachment.converter.AttachmentTypeConverters
import com.ivy.core.persistence.entity.trn.TrnEntity
import com.ivy.core.persistence.entity.trn.TrnLinkRecordEntity
import com.ivy.core.persistence.entity.trn.TrnMetadataEntity
import com.ivy.core.persistence.entity.trn.converter.TrnTypeConverters

@Database(
    entities = [
        TrnEntity::class, TrnLinkRecordEntity::class,
        TrnMetadataEntity::class, AttachmentEntity::class,
        AccountEntity::class, AccountFolderEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(
    GeneralTypeConverters::class,
    TrnTypeConverters::class, AttachmentTypeConverters::class,
)
abstract class IvyWalletDb : RoomDatabase() {
    abstract fun trnDao(): TrnDao

    abstract fun trnLinkRecordDao(): TrnLinkRecordDao

    abstract fun trnMetadataDao(): TrnMetadataDao

    abstract fun attachmentDao(): AttachmentDao

    abstract fun accountDao(): AccountDao

    abstract fun accountFolderDao(): AccountFolderDao
}