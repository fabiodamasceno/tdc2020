//
//  RNManager.swift
//  ChatApp
//
//  Created by Fábio Damasceno on 24/08/20.
//  Copyright © 2020 Lambda3. All rights reserved.
//

import Foundation
import React

@objc(RNManager) public class RNManager : NSObject {
    
    private var _rnBridge: RNBridge
    
    public override init() {
        _rnBridge = RNBridge()
    }

    @objc static func requiresMainQueueSetup() -> Bool {
        return false
    }
    
    public func loadReactNativeView(moduleName: String, initialProperties: [String: Any]) -> RCTRootView {
        let bridge = _rnBridge.getBridge()
        let view = RCTRootView(bridge: bridge!, moduleName: moduleName, initialProperties:initialProperties)
        return view
    }

    @objc public func dismiss() {
        DispatchQueue.main.async {
            if let rootViewController = self.getRootViewController() {
                let topMostViewController = rootViewController.topMostViewController()
                topMostViewController.dismiss(animated: true)
            }
        }
    }
    
    private func getRootViewController() -> UIViewController? {
        if let window = UIApplication.shared.keyWindow {
            if let rootViewController = window.rootViewController {
                return rootViewController
            }
        }
        return nil
    }
}

extension UIViewController {
    func topMostViewController() -> UIViewController {
        if let presented = self.presentedViewController {
            return presented.topMostViewController()
        }
        
        if let navigation = self as? UINavigationController {
            return navigation.visibleViewController?.topMostViewController() ?? navigation
        }
        
        if let tab = self as? UITabBarController {
            return tab.selectedViewController?.topMostViewController() ?? tab
        }
        return self
    }
}
