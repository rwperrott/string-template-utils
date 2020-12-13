package rwperrott.stringtemplate.v4;

import java.util.List;

/**
 * Provided, so don't have to w an extended ArrayList in another object, to prevent modification.
 */
public interface MemberInvokers {
    MemberInvokers NONE = new MemberInvokers() {
        @Override
        public int maxTypeConverterCount() {
            return 0;
        }

        @Override
        public MemberInvoker find(final boolean onlyPublic, final Class<?> returnType, final List<Object> args, final int extrasLen) {
            return null;
        }
    };
    /**
     * Used by AbstractInvokeAdaptor
     */
    int maxTypeConverterCount();

    /**
     * Used by AbstractInvokeAdaptor and StringInvokeRenderer
     */
    MemberInvoker find(final boolean onlyPublic,
                       final Class<?> returnType,
                       final List<Object> args,
                       final int extrasLen);

    default MemberInvoker find(final boolean onlyPublic,
                       final Class<?> returnType,
                       final List<Object> args) {
        return find(onlyPublic, returnType, args, 0);
    }
}