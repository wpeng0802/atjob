CREATE TABLE "AUTH_USER_ROLE" (
    "USER_ID" VARCHAR2(36),
    "ROLE_ID" VARCHAR2(36)
);

COMMENT ON COLUMN "AUTH_USER_ROLE"."ROLE_ID" IS 'ROLE_ID';

COMMENT ON COLUMN "AUTH_USER_ROLE"."USER_ID" IS 'USER_ID';

COMMENT ON TABLE "AUTH_USER_ROLE" IS '用户拥有的角色';