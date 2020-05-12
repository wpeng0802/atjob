
  CREATE TABLE "AUTH_DEPT" 
   (	"DEPT_ID" VARCHAR2(36) NOT NULL ENABLE, 
	"NAME" VARCHAR2(255), 
	"CODE" VARCHAR2(255), 
	"TREE_IDS" VARCHAR2(1000), 
	"PARENT" VARCHAR2(36), 
	"IS_LEAF" NUMBER(1,0), 
	"NODE_LEVEL" NUMBER(10,0), 
	"INPUT_CODE" VARCHAR2(255), 
	"INDEX_FIELD" NUMBER(10,0), 
	"DESCRIPTION" VARCHAR2(255), 
	"IS_STOP" NUMBER(1,0), 
	"CREATE_TIME" DATE, 
	"NAME_EN" VARCHAR2(255), 
	"CREATE_USER_ID" VARCHAR2(36), 
	"MODIFY_USER_ID" VARCHAR2(36), 
	"MODIFY_TIME" DATE, 
	 CONSTRAINT "PK_AUTH_DEPT" PRIMARY KEY ("DEPT_ID"));

   COMMENT ON COLUMN "AUTH_DEPT"."DEPT_ID" IS 'DEPT_ID';
   COMMENT ON COLUMN "AUTH_DEPT"."NAME" IS '部门名称';
   COMMENT ON COLUMN "AUTH_DEPT"."CODE" IS '部门编码';
   COMMENT ON COLUMN "AUTH_DEPT"."TREE_IDS" IS '树父节点集合';
   COMMENT ON COLUMN "AUTH_DEPT"."PARENT" IS '父节ID';
   COMMENT ON COLUMN "AUTH_DEPT"."IS_LEAF" IS '是否叶';
   COMMENT ON COLUMN "AUTH_DEPT"."NODE_LEVEL" IS '节点深度';
   COMMENT ON COLUMN "AUTH_DEPT"."INPUT_CODE" IS '录入码';
   COMMENT ON COLUMN "AUTH_DEPT"."INDEX_FIELD" IS '排序';
   COMMENT ON COLUMN "AUTH_DEPT"."DESCRIPTION" IS '描述';
   COMMENT ON COLUMN "AUTH_DEPT"."IS_STOP" IS '是否停用';
   COMMENT ON COLUMN "AUTH_DEPT"."CREATE_TIME" IS '创建时间';
   COMMENT ON COLUMN "AUTH_DEPT"."NAME_EN" IS '部门名称英文';
   COMMENT ON COLUMN "AUTH_DEPT"."CREATE_USER_ID" IS '创建人Id@AUTH_USER';
   COMMENT ON COLUMN "AUTH_DEPT"."MODIFY_USER_ID" IS '修改人id@AUTH_USER';
   COMMENT ON COLUMN "AUTH_DEPT"."MODIFY_TIME" IS '修改时间';
   COMMENT ON TABLE "AUTH_DEPT"  IS '部门';