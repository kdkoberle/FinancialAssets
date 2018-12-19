package com.financialassets.persistence;

import com.financialassets.entity.UserAsset;

import java.util.ArrayList;
import java.util.List;

public class Common {


    /**
     *
     * @param userId
     * @return list of UserAssets belonging to userId
     */
    public List<UserAsset> matchUserAssets(int userId) {
        DaoFactory userAssetDao = new DaoFactory(UserAsset.class);

        List<UserAsset> allUserAssets = userAssetDao.getAll();

        List<UserAsset> matchOfUserAssets = new ArrayList<UserAsset>();

        for (UserAsset userAsset : allUserAssets) {
            if(userAsset.getUser().getUserId() == userId) {
                userAsset.setUnsoldGainOrLoss(userAsset.getAssetName());
                matchOfUserAssets.add(userAsset);
            }
        }

        return matchOfUserAssets;
    }


}
