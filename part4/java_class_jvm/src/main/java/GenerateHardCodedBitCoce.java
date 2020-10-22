import java.io.DataOutputStream;
import java.io.IOException;

import static sun.tools.java.RuntimeConstants.opc_wide;

public class GenerateHardCodedBitCoce {
    public static void main(String[] args) {

    }

    private void codeLocalLoadStore(int lvar, int opcode, int opcode_0, DataOutputStream out) throws IOException {
        assert lvar >= 0 && lvar <= 0xFFFF;
        // 根据变量数值，以不同格式，dump操作码
        if (lvar <= 3) {
            out.writeByte(opcode_0 + lvar);
        } else if (lvar <= 0xFF) {
            out.writeByte(opcode);
            out.writeByte(lvar & 0xFF);
        } else {
            // 使用宽指令修饰符，如果变量索引不能用无符号byte
            out.writeByte(opc_wide);
            out.writeByte(opcode);
            out.writeShort(lvar & 0xFFFF);
        }
    }
}
