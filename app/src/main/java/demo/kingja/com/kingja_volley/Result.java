package demo.kingja.com.kingja_volley;

/**
 * Description:TODO
 * Create Time:2017/5/13 10:29
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class Result {

    /**
     * resultCode : 0
     * resultText : 登录成功
     * resultData : {"accountId":9,"name":"aaa","nickName":"","phone":"","token":"3cc41f88ed2942d0b944220cdc626677",
     * "avatar":"/upload/avatar/head_9.jpg","coin":99674,"experience":146,"attentionCount":0,"fansCount":0,
     * "rankInfo":{"rank":3,"upExperience":420,"title":"初出茅庐3","currentExperience":146}}
     */

    private int resultCode;
    private String resultText;
    private ResultDataBean resultData;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }

    public ResultDataBean getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataBean resultData) {
        this.resultData = resultData;
    }

    public static class ResultDataBean {
        /**
         * accountId : 9
         * name : aaa
         * nickName :
         * phone :
         * token : 3cc41f88ed2942d0b944220cdc626677
         * avatar : /upload/avatar/head_9.jpg
         * coin : 99674
         * experience : 146
         * attentionCount : 0
         * fansCount : 0
         * rankInfo : {"rank":3,"upExperience":420,"title":"初出茅庐3","currentExperience":146}
         */

        private int accountId;
        private String name;
        private String nickName;
        private String phone;
        private String token;
        private String avatar;
        private int coin;
        private int experience;
        private int attentionCount;
        private int fansCount;
        private RankInfoBean rankInfo;

        public int getAccountId() {
            return accountId;
        }

        public void setAccountId(int accountId) {
            this.accountId = accountId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }

        public int getAttentionCount() {
            return attentionCount;
        }

        public void setAttentionCount(int attentionCount) {
            this.attentionCount = attentionCount;
        }

        public int getFansCount() {
            return fansCount;
        }

        public void setFansCount(int fansCount) {
            this.fansCount = fansCount;
        }

        public RankInfoBean getRankInfo() {
            return rankInfo;
        }

        public void setRankInfo(RankInfoBean rankInfo) {
            this.rankInfo = rankInfo;
        }

        public static class RankInfoBean {
            /**
             * rank : 3
             * upExperience : 420
             * title : 初出茅庐3
             * currentExperience : 146
             */

            private int rank;
            private int upExperience;
            private String title;
            private int currentExperience;

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getUpExperience() {
                return upExperience;
            }

            public void setUpExperience(int upExperience) {
                this.upExperience = upExperience;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getCurrentExperience() {
                return currentExperience;
            }

            public void setCurrentExperience(int currentExperience) {
                this.currentExperience = currentExperience;
            }
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultText='" + resultText + '\'' +
                '}';
    }
}
