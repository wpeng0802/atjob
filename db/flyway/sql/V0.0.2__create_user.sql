CREATE TABLE "AUTH_USER" (
  "USER_ID" VARCHAR2(36) NOT NULL ENABLE,
  "DEPT_ID" VARCHAR2(36),
  "DEPT_NAME" VARCHAR2(255),
  "NAME" VARCHAR2(255),
  "CODE" VARCHAR2(255),
  "LOGIN_NAME" VARCHAR2(255),
  "PWD" VARCHAR2(255),
  "INPUT_CODE" VARCHAR2(255),
  "INDEX_FIELD" NUMBER(10, 0),
  "DESCRIPTION" VARCHAR2(255),
  "PHONE" VARCHAR2(255),
  "IS_STOP" NUMBER(1, 0),
  "CREATE_TIME" DATE,
  "CREATE_USER_ID" VARCHAR2(36),
  "MODIFY_USER_ID" VARCHAR2(36),
  "MODIFY_TIME" DATE,
  CONSTRAINT "PK_AUTH_USER" PRIMARY KEY ("USER_ID");

COMMENT ON COLUMN "AUTH_USER"."USER_ID" IS 'USER_ID';

COMMENT ON COLUMN "AUTH_USER"."DEPT_ID" IS 'DEPT_ID';

COMMENT ON COLUMN "AUTH_USER"."DEPT_NAME" IS '部门名称';

COMMENT ON COLUMN "AUTH_USER"."NAME" IS '用户显示名';

COMMENT ON COLUMN "AUTH_USER"."CODE" IS '用户编码';

COMMENT ON COLUMN "AUTH_USER"."LOGIN_NAME" IS '登录名';

COMMENT ON COLUMN "AUTH_USER"."PWD" IS '密码';

COMMENT ON COLUMN "AUTH_USER"."INPUT_CODE" IS '录入码';

COMMENT ON COLUMN "AUTH_USER"."INDEX_FIELD" IS '排序';

COMMENT ON COLUMN "AUTH_USER"."DESCRIPTION" IS '描述';

COMMENT ON COLUMN "AUTH_USER"."PHONE" IS '电话';

COMMENT ON COLUMN "AUTH_USER"."IS_STOP" IS '是否停用';

COMMENT ON COLUMN "AUTH_USER"."CREATE_TIME" IS '创建时间';

COMMENT ON COLUMN "AUTH_USER"."CREATE_USER_ID" IS '创建人Id@AUTH_USER';

COMMENT ON COLUMN "AUTH_USER"."MODIFY_USER_ID" IS '修改人id@AUTH_USER';

COMMENT ON COLUMN "AUTH_USER"."MODIFY_TIME" IS '修改时间';

COMMENT ON TABLE "AUTH_USER" IS '系统用户';