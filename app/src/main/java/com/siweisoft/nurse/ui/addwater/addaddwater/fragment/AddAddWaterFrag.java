package com.siweisoft.nurse.ui.addwater.addaddwater.fragment;

import com.siweisoft.app.R;
import com.siweisoft.lib.base.ui.ope.BaseDAOpe;
import com.siweisoft.lib.base.ui.ope.BaseDBOpe;
import com.siweisoft.nurse.nursenet.NurseNetOpe;
import com.siweisoft.nurse.ui.base.fragment.BaseNurseFrag;
import com.siweisoft.nurse.ui.base.ope.BaseNurseOpes;
import com.siweisoft.nurse.ui.base.ope.BaseNurseUIOpe;

/**
 * Created by ${viwmox} on 2017-02-17.
 */

public class AddAddWaterFrag extends BaseNurseFrag<BaseNurseUIOpe,NurseNetOpe,BaseDBOpe,BaseDAOpe>{


    @Override
    public BaseNurseOpes<BaseNurseUIOpe, NurseNetOpe, BaseDBOpe, BaseDAOpe> getOpe() {
        return null;
    }

    @Override
    public int getContainView() {
        return R.layout.frag_addaddwater;
    }
}
