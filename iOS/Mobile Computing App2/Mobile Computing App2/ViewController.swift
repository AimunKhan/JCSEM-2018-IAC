//
//  ViewController.swift
//  Mobile Computing App2
//
//  Created by Aimun Khan on 11/8/18.
//  Copyright © 2018 Aimun Khan. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    
    //var favecolor = "Red"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadData()
    }
    func loadData(favecolor: String = "Red") {
        view.subviews.forEach({ $0.removeFromSuperview() }) // this gets things done
        // Do any additional setup after loading the view, typically from a nib.
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 200, height: 21))
        label.center = CGPoint(x: 200, y: 285)
        label.textAlignment = .center
        
        // Change color based on favecolor variable
        switch favecolor{
        case "Red":
            label.textColor = UIColor(displayP3Red: 1.0, green: 0.0, blue: 0.0, alpha: 1.0)
        case "Blue":
            label.textColor = UIColor(displayP3Red: 0.0, green: 0.0, blue: 1.0, alpha: 1.0)
        case "Green":
            label.textColor = UIColor(displayP3Red: 0.0, green: 1.0, blue: 0.0, alpha: 1.0)
        case "Yellow":
            label.textColor = UIColor(displayP3Red: 1.0, green: 1.0, blue: 0.0, alpha: 1.0)
        default:
            label.textColor = UIColor(displayP3Red: 0.0, green: 0.0, blue: 0.0, alpha: 1.0)
        }
        
        // Change label
        label.text = "My favorite color is: \(favecolor)"
        self.view.addSubview(label)
        //print(NSDate().timeIntervalSince1970)
        let time = NSDate().timeIntervalSince1970
        let date = NSDate(timeIntervalSince1970: time)
        let dayTimePeriodFormatter = DateFormatter()
        dayTimePeriodFormatter.dateFormat = "MMM dd YYYY hh:mm:ss.SSSS a"
        let dateString = dayTimePeriodFormatter.string(from: date as Date)
        print( " It is \(dateString) also is \(time)")

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }




}

