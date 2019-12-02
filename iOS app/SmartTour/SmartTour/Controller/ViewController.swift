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
        
        for i in 1...100 {
            beaconDropDown.optionArray.append("Beacon "+"\(i)")
            beaconDropDown.optionIds?.append(i)
        }
        
        beaconDropDown.didSelect{(selectedText , index ,id) in
            self.beaconId = "\(index+1)"
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
            ) as? DetailsViewController, let bId = beaconId
        {
            findBtn.startAnimation()
            AF.request(Constant.host + bId, method: .get).responseJSON { (response) in
                
                switch response.result {
                case .success:
                    print("Validation Successful)")

                    if let json = response.data {
                        do{
                            let json = try JSONSerialization.jsonObject(with: json, options: .allowFragments)
                            if let result = json as? [String: String] {
                                print("DATA PARSED: \(result)")
                                
                                var artwork = Artwork()
                                artwork.beaconID = result["beaconID"] ?? artwork.beaconID
                                artwork.title = result["title"] ?? artwork.title
                                artwork.accessionNumber = result["accessionNo"] ?? artwork.accessionNumber
                                artwork.medium = result["medium"] ?? artwork.medium
                                artwork.thumbnailURL = result["thumbnailURL"] ?? artwork.thumbnailURL
                                artwork.classification = result["classification"] ?? artwork.classification
                                artwork.dateAcquired = result["dateAcq"] ?? artwork.dateAcquired
                                artwork.constituentID = result["constituentID"] ?? artwork.constituentID
                                artwork.artistBio = result["artistBio"] ?? artwork.artistBio
                                artwork.artistName = result["artistName"] ?? artwork.artistName
                                artwork.gender = result["gender"] ?? artwork.gender
                                
                                if let beginDate = result["beginDate"], let endDate = result["endDate"] {
                                    artwork.beginEndDate = "( " + beginDate + "-" + endDate + " )"
                                }
                                vc.artwork = artwork
                            }
                            
                            
                            DispatchQueue.main.async { [weak self] in
                                self?.findBtn.stopAnimation(animationStyle: .expand, completion: {
                                    self?.present(vc, animated: true, completion: nil)
                                })
                            }
                        }
                        catch{
                            print("JSON Error")
                            DispatchQueue.main.async { [weak self] in
                                self?.findBtn.stopAnimation(animationStyle: .shake, completion: {
                                    CustomAlert.showAlert(title: "Error!!!", message: "This time it's not you, it's us. Try in a few minutes.", cancelButtonTitle: "Ok")

                                })
                            }
                        }
                    }
                case .failure(let error):
                    print(error)
                    DispatchQueue.main.async { [weak self] in
                        self?.findBtn.stopAnimation(animationStyle: .shake, completion: {
                            CustomAlert.showAlert(title: "No Artwork Found!!!", message: "Please try with another beacon", cancelButtonTitle: "Ok")
                            
                        })
                    }

                }

            }
        } else if beaconId == nil {
            CustomAlert.showAlert(title: "No Beacon Selected!!!", message: "Please select a beacon to proceed.", cancelButtonTitle: "Ok")
        }
    }
}
