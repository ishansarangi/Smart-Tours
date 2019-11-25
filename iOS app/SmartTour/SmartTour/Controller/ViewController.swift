//
//  ViewController.swift
//  SmartTour
//
//  Created by Ishan Sarangi on 11/21/19.
//  Copyright © 2019 Ishan Sarangi. All rights reserved.
//

import UIKit
import iOSDropDown
import TransitionButton
import Alamofire

class ViewController: UIViewController {
    
    @IBOutlet weak var beaconDropDown: DropDown!
    @IBOutlet weak var findBtn: TransitionButton!
    
    var beaconId: String?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        beaconDropDown.optionArray = ["Beacon 1", "Beacon 2", "Beacon 3"]
        
        beaconDropDown.didSelect{(selectedText , index ,id) in
            self.beaconId = selectedText
        }
        
        findBtn.layer.borderWidth = 1
        findBtn.layer.borderColor = UIColor.blue.cgColor
        findBtn.cornerRadius = 30
        findBtn.spinnerColor = .white
        
    }
    
    @IBAction func findTapped(_ sender: Any) {
        let mainStoryboard = UIStoryboard(name: "Main", bundle: nil)
        if let vc = mainStoryboard
            .instantiateViewController(
                withIdentifier: "DetailsViewController"
            ) as? DetailsViewController
        {
            AF.request("", method: .get).responseJSON { (response) in
                
            }
            vc.artwork = Artwork()
            self.navigationController?.pushViewController(vc, animated: true)
        }
    }
}
