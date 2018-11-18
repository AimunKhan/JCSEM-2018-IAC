//
//  ViewController.swift
//  Mobile Computing App1
//
//  Created by Aimun Khan on 11/6/18.
//  Copyright © 2018 Aimun Khan. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource  {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        //pickerView.delegate = self
        //pickerView.dataSource = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    let colors = ["Red","Yellow","Green","Blue"]
    var favecolor = "Red"

    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return colors.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return colors[row]
    }

    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        favecolor = colors[row]
    }
    @IBAction func buttonPress(_ sender: Any) {
        //print(NSDate().timeIntervalSince1970)
        let time = NSDate().timeIntervalSince1970
        let date = NSDate(timeIntervalSince1970: time)
        let dayTimePeriodFormatter = DateFormatter()
        dayTimePeriodFormatter.dateFormat = "MMM dd YYYY hh:mm:ss.SSSS a"
        let dateString = dayTimePeriodFormatter.string(from: date as Date)
        print( " It is \(dateString) also is \(time)")

        if let appURL = URL(string: "MobileComputingApp2://") {
            let canOpen = UIApplication.shared.canOpenURL(appURL)
            print("\(canOpen)")
            
            let appName = "MobileComputingApp2"
            let appScheme = "\(appName)://\(favecolor)"
            let appSchemeURL = URL(string: appScheme)
            
            if UIApplication.shared.canOpenURL(appSchemeURL! as URL) {
                UIApplication.shared.open(appSchemeURL!, options: [:], completionHandler: nil)
            }
            else {
                let alert = UIAlertController(title: "\(appName) Error...", message: "The app named \(appName) is not opening", preferredStyle: .alert)
                alert.addAction(UIAlertAction(title: "OK", style: .default, handler: nil))
                self.present(alert, animated: true, completion: nil)
            }
        }
        else {
            print("Mobile Computing App2 was not found")
        }
    }
}

