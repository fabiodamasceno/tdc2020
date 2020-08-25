//
//  RNBridge.swift
//  ChatApp
//
//  Created by Fábio Damasceno on 24/08/20.
//  Copyright © 2020 Lambda3. All rights reserved.
//

import Foundation
import React

public class RNBridge {
    init() {
        createBridge()
    }
    
    func getBridge() -> RCTBridge? {
        return RNBridge._sharedBridge
    }

    private static var _sharedBridge: RCTBridge? = nil
    private static var _bundleURLProvider: RCTBundleURLProvider? = nil

    private func createBridge() -> Void {
        if(RNBridge._bundleURLProvider == nil) {
            RNBridge._bundleURLProvider = RCTBundleURLProvider()
        }
        if(RNBridge._sharedBridge == nil) {
            let bundleURL = getBundleURL() ??  URL.init(fileURLWithPath: "", isDirectory: false)
            RNBridge._sharedBridge = RCTBridge(bundleURL: bundleURL, moduleProvider:nil, launchOptions:[:])
        }
    }

    private func getBundleURL() -> URL? {
        #if DEBUG
        return RCTBundleURLProvider.sharedSettings().jsBundleURL(forBundleRoot: "index", fallbackResource: "main.jsbundle")
        #else
        return Bundle.main.url(forResource: "main", withExtension: "jsbundle")
        #endif
    }
}
