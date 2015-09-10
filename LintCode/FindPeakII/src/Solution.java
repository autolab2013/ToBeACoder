import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riley on 9/7/2015.
 */
class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if(A == null || A.length == 0) return result;
        int rows = A.length;
        int cols = A[0].length;
        update(result, A, 0, rows-1, 0, cols-1);
        return result;
    }

    private void update(List<Integer> result, int[][] A, int rs, int re, int cs, int ce) {
        if(rs > re || cs > ce) return ;
        if(rs + 1 < re && cs + 1 < ce) {
            int rm = (rs + re) / 2;
            int cm = (cs + ce) / 2;
            if(isPeak(A, rm, cm)) {
                result.add(rm);
                result.add(cm);
                return ;
            }
            if(rm - 1 >= 0 && A[rm-1][cm] > A[rm][cm]) {
                if(cm - 1 >= 0 && A[rm][cm-1] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, cs, cm);
                }
                if(cm + 1 < A[0].length && A[rm][cm+1] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, cm, ce);
                }
            }
            if(rm + 1 < A.length && A[rm+1][cm] > A[rm][cm]) {
                if(cm - 1 >= 0 && A[rm][cm-1] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, cs, cm);
                }
                if(cm + 1 < A[0].length && A[rm][cm+1] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, cm, ce);
                }
            }
            if(cm - 1 >= 0 && A[rm][cm-1] > A[rm][cm]) {
                if(rm - 1 >= 0 && A[rm-1][cm] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, cs, cm);
                }
                if(rm + 1 < A.length && A[rm+1][cm] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, cs, cm);
                }
            }
            if(cm + 1 < A[0].length && A[rm][cm+1] > A[rm][cm]) {
                if(rm - 1 >= 0 && A[rm-1][cm] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, cm, ce);
                }
                if(rm + 1 < A.length && A[rm+1][cm] > A[rm][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, cm, ce);
                }
            }
        } else {
            if(rs + 1 < re) {
                int rm = (rs + re) / 2;
                if(rm - 1 >= 0 && A[rm-1][cs] > A[rm][cs]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, cs, cs);
                }
                if(rm - 1 >= 0 && A[rm-1][ce] > A[rm][ce]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rm, ce, ce);
                }
                if(rm + 1 < A.length && A[rm+1][cs] > A[rm][cs]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, cs, cs);
                }
                if(rm + 1 < A.length && A[rm+1][ce] > A[rm][ce]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rm, re, ce, ce);
                }
            }
            if(cs + 1 < ce) {
                int cm = (cs + ce) / 2;
                if(cm - 1 >= 0 && A[rs][cm-1] > A[rs][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rs, cs, cm);
                }
                if(cm - 1 >= 0 && A[re][cm-1] > A[re][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, re, re, cs, cm);
                }
                if(cm + 1 < A[0].length && A[rs][cm+1] > A[rs][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, rs, rs, cm, ce);
                }
                if(cm + 1 < A[0].length && A[re][cm+1] > A[re][cm]) {
                    if(!result.isEmpty()) return ;
                    update(result, A, re, re, cm, ce);
                }
            }
        }

    }


    private boolean isPeak(int[][] A, int r, int c) {
        boolean up = r-1 >= 0 ? A[r-1][c] < A[r][c] : true;
        boolean down = r+1 < A.length ? A[r+1][c] < A[r][c] : true;
        boolean left = c-1 >= 0 ? A[r][c-1] < A[r][c] : true;
        boolean right = c+1 < A[0].length ? A[r][c+1] < A[r][c] : true;
        return up && down && left && right;
    }


}

