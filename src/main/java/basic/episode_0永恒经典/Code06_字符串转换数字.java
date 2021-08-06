package basic.episode_0永恒经典;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zyf
 * @date: 2021/8/6 22:50
 * @description: leetcode8 状态机demo
 */
public class Code06_字符串转换数字 {
    public int myAtoi(String s) {
        AutoState autoState = new AutoState(s);
        for(int i=0;i<s.length();i++){
            autoState.getStateAndCal(i);
        }
        return (int)(autoState.positive*autoState.sum);
    }

    static class AutoState{
        int positive = 1;
        long sum = 0;
        Map<String,String[]> stateMap;
        String s;
        String curState = "start";
        AutoState(String s){
            this.s = s;
            stateMap = new HashMap<>();
            stateMap.put("start",new String[]{"start","mark","int","end"});
            stateMap.put("mark",new String[]{"end","end","int","end"});
            stateMap.put("int",new String[]{"end","end","int","end"});
            stateMap.put("end",new String[]{"end","end","end","end"});
        }

        public void getStateAndCal(int i){
            char c = s.charAt(i);
            int index = getIndex(c);
            curState = stateMap.get(curState)[index];
            if("mark".equals(curState)&&c=='-')positive=-1;
            if("int".equals(curState)){
                sum=10*sum+(c-'0');
                sum = positive==1?Math.min(sum,(long)Integer.MAX_VALUE):Math.min(sum,-(long)Integer.MIN_VALUE);
            }
        }

        private int getIndex(char c) {
            if(c==' ')return 0;
            if(c=='+'||c=='-')return 1;
            if(c>='0'&&c<='9')return 2;
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code06_字符串转换数字().myAtoi(" -42"));
    }
}
